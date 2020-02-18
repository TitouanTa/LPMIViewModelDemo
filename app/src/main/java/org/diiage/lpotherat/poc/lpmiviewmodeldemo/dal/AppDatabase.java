package org.diiage.lpotherat.poc.lpmiviewmodeldemo.dal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.diiage.lpotherat.poc.lpmiviewmodeldemo.model.Operation;


/**
 * On crée une classe qui nous fournira l'accès à la base de donnée
 * vi les DAO
 *
 * On y ajoute l'annotation @Database en lui indiquant la
 * liste de toutes les entités, et la version courante.
 */
@Database(entities = Operation.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract OperationDao operationDao();

}
