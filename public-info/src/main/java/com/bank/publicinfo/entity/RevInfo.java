package com.bank.publicinfo.entity;

import com.bank.publicinfo.audit.Listener.BankDetailsListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RevisionEntity(BankDetailsListener.class)
@Table(name = "REVINFO", schema = "public")
public class RevInfo {
    @Id
    @RevisionNumber
    @GeneratedValue (generator = "CustomerAuditRevisionSeq")
    @SequenceGenerator(name = "CustomerAuditRevisionSeq", sequenceName = "customer_audit_revision_seq",
            schema = "public_bank_information", allocationSize = 1)
    private int id;

    @RevisionTimestamp
    private long timestamp;

    private String username;

    @OneToOne
    @JoinColumn( name = "audit_id", referencedColumnName = "id")
    private Audit audit;
}
