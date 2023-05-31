package com.bank.publicinfo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table (name = "audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fill in the field")
    @Size(max = 40, message = "Should not exceed 40 symbols")
    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @NotBlank(message = "Fill in the field")
    @Size(max = 255, message = "Should not exceed 255 symbols")
    @Column(name = "operation_type", nullable = false)
    private String operationType;

    @NotBlank(message = "Fill in the field")
    @Size(max = 255, message = "Should not exceed 255 symbols")
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Size(max = 255, message = "Should not exceed 255 symbols")
    @Column(name = "modified_by")
    private String modifiedBy;

    @NotEmpty(message = "Fill in the field")
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "new_entity_json")
    private String newEntityJson;

    @NotBlank(message = "Fill in the field")
    @Column(name = "entity_json", nullable = false)
    private String entityJson;

    public Audit() {
    }

    public Audit(String entityType, String operationType, String createdBy, String modifiedBy, Timestamp createdAt, Timestamp modifiedAt, String newEntityJson, String entityJson) {
        this.entityType = entityType;
        this.operationType = operationType;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.newEntityJson = newEntityJson;
        this.entityJson = entityJson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getNewEntityJson() {
        return newEntityJson;
    }

    public void setNewEntityJson(String newEntityJson) {
        this.newEntityJson = newEntityJson;
    }

    public String getEntityJson() {
        return entityJson;
    }

    public void setEntityJson(String entityJson) {
        this.entityJson = entityJson;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", entityType='" + entityType + '\'' +
                ", operationType='" + operationType + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", newEntityJson='" + newEntityJson + '\'' +
                ", entityJson='" + entityJson + '\'' +
                '}';
    }
}
