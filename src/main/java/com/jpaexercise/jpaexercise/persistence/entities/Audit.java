package com.jpaexercise.jpaexercise.persistence.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {
    
    @Column( name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersistAudit(){
        this.createdAt = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdateAudit(){
        this.updatedAt = LocalDateTime.now();
    }

    public Audit() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    


    
}
