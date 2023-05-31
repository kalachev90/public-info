package com.bank.publicinfo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class AuditDTO {
    @NotBlank(message = "Fill in the field")
    @Size(max = 40, message = "Should not exceed 40 symbols")
    private String entityType;

    @NotBlank(message = "Fill in the field")
    @Size(max = 255, message = "Should not exceed 255 symbols")
    private String operationType;

    @NotBlank(message = "Fill in the field")
    @Size(max = 255, message = "Should not exceed 255 symbols")
    private String createdBy;

    @Size(max = 255, message = "Should not exceed 255 symbols")
    private String modifiedBy;

    @NotEmpty(message = "Fill in the field")
    private Timestamp createdAt;

    private Timestamp modifiedAt;

    private String newEntityJson;

    @NotBlank(message = "Fill in the field")
    private String entityJson;

    public AuditDTO() {
    }

    public AuditDTO(String entityType, String operationType, String createdBy, String modifiedBy,
                    Timestamp createdAt, Timestamp modifiedAt, String newEntityJson, String entityJson) {
        this.entityType = entityType;
        this.operationType = operationType;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.newEntityJson = newEntityJson;
        this.entityJson = entityJson;
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
}
