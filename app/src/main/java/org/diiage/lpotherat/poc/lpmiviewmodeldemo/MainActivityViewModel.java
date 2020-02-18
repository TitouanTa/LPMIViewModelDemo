package org.diiage.lpotherat.poc.lpmiviewmodeldemo;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.diiage.lpotherat.poc.lpmiviewmodeldemo.dal.AppDatabase;

public class MainActivityViewModel extends ViewModel {

    public static class Factory implements ViewModelProvider.Factory{

        AppDatabase appDatabase;

        public Factory(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            //noinspection unchecked
            return (T) new MainActivityViewModel(appDatabase);
        }
    }

    //Type mutablelivedata, permet d'avoir un flux de données
    //bidirectionnel lecture / écriture
    MutableLiveData<String> val1;
    MutableLiveData<String> val2;

    //Type livedata, fourni un flux unidirectionel en lecture
    LiveData<String> resultat;

    public MainActivityViewModel(AppDatabase appDatabase) {



        val1 = new MutableLiveData<>();
        val2 = new MutableLiveData<>();

        //Un mediatorlivedata permet de conciler plusieurs sources de données
        //Dans cet exemple, résultat est abonné à val1 et val2.
        //Pour chaque changement dans val1 ou val2, on affecte dans resultat
        //la somme des deux valeurs.
        resultat = new MediatorLiveData<String>(){{
            //Ajout de val1 en tant que source de données
            addSource(val1,string -> {
                try {
                    //Récupération de la valeur courante de val1
                    int intVal1 = Integer.valueOf(string);
                    //Récupération de la valeur courante de val2
                    int intVal2 = Integer.valueOf(val2.getValue());
                    //Affectation de la somme au MediatorLiveData
                    setValue(String.valueOf(intVal1 + intVal2));
                } catch (Exception ex){
                    setValue("");
                }
            });

            //Ajout de val2 en tant que source de données
            addSource(val2, string -> {
                try {
                    int intVal1 = Integer.valueOf(val1.getValue());
                    int intVal2 = Integer.valueOf(string);
                    setValue(String.valueOf(intVal1 + intVal2));
                } catch (Exception ex){
                    setValue("");
                }
            });
        }};

    }

    /**
     * Exposition du flux bidirectionnel val1 à la vue
     * @return
     */
    public MutableLiveData<String> getVal1() {
        return val1;
    }

    /**
     * Exposition du flux biidirectionnel val2 à la vue
     * @return
     */
    public MutableLiveData<String> getVal2() {
        return val2;
    }

    /**
     * Exposition d'un flux unidirectionel du résultat à la vue
     * @return
     */
    public LiveData<String> getResultat() {
        return resultat;
    }
}
