package com.NewsViews;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Service
public class CRUD_Service {


    public String createUser(CRUD crud) throws ExecutionException, InterruptedException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("CRUD_Data").document(crud.getId()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public CRUD getUser(String id) throws ExecutionException, InterruptedException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("CRUD_Data").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            return document.toObject(CRUD.class);
        } else {
            return null;
        }
    }

    public String updateUser(CRUD crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("CRUD_Data").document(crud.getId());
        ApiFuture<WriteResult> collectionsApiFuture = documentReference.set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    public String deleteUser(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("CRUD_Data").document(id).delete();
        return "Successfully deleted " + id;
    }
}
