package org.diiage.lpotherat.poc.lpmiviewmodeldemo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


/**
 * Ma classe de modèle, c'est ses instances qui seront stockées
 * dans chaque ligne de la table du nom de la classe
 *
 * Il faut qu'elle soit déclarée avec l'annotation @Entity
 */
@Entity
public class Operation {
    //On déclare ici la clé primaire avec l'annotation
    //@PrimaryKey
    @PrimaryKey
    private long id;
    private int val1;
    private int val2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}
