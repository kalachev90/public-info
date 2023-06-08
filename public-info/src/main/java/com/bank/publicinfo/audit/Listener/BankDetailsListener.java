package com.bank.publicinfo.audit.Listener;

import com.bank.publicinfo.audit.BeanUtil;
import com.bank.publicinfo.entity.Audit;
import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.entity.RevInfo;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionListener;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class BankDetailsListener implements RevisionListener {
    @Override
    public void newRevision(Object revision) {
        EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
        AuditQuery auditQuery = AuditReaderFactory.get(entityManager).createQuery()
                .forRevisionsOfEntity(BankDetails.class, false, true);
        List<Object[]> resultList = auditQuery.getResultList();
        if (resultList.size() == 0) {
            return;
        }
        Object[] resultArr = resultList.get(resultList.size()-1);
        BankDetails bankDetails = (BankDetails) resultArr[0];
        RevInfo revInfo = (RevInfo) resultArr[1];
        RevisionType revisionType = (RevisionType) resultArr[2];
        revInfo.setUsername("User");

        Audit audit = new Audit();

        ZonedDateTime zonedDateTimeOfRevision = ZonedDateTime.ofInstant(Instant.ofEpochMilli(revInfo.getTimestamp()),
                ZoneId.systemDefault());
        audit.setEntityType(bankDetails.getClass().getSimpleName());
        audit.setOperationType(revisionType.toString());
        if (revisionType.toString() =="MOD") {
            audit.setNewEntityJson(bankDetails.toString());
            audit.setModifiedAt(zonedDateTimeOfRevision.toLocalDateTime());
            audit.setModifiedBy(revInfo.getUsername());
            audit.setEntityJson(resultList.get(resultList.size() - 2)[0].toString());
        } else {
            audit.setEntityJson(bankDetails.toString());
        }
        audit.setCreatedBy(revInfo.getUsername());
        audit.setCreatedAt(zonedDateTimeOfRevision.toLocalDateTime());
        audit.setRevInfo(revInfo);
        entityManager.persist(audit);
        revInfo.setAudit(audit);
    }
}
