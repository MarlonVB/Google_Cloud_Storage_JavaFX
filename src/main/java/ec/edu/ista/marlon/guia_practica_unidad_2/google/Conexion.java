package ec.edu.ista.marlon.guia_practica_unidad_2.google;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//
public class Conexion {

    public void subirArchivo(String projectId, String bucketName, String objectName, String filePath) throws IOException {

         String proyecto_id = "durable-sound-356201";

         String nombreBucket = "guia_bucket_tendencias";

         String nombreDeArchivo = "moodboard_prueba";

         String pathArchivo ="C:\\Users\\velez\\Documents\\IntelliJ Projects\\Guia_Practica_Unidad_2\\src\\main\\resources\\ec\\edu\\ista\\marlon\\moodboard.pdf";

        Storage storage = StorageOptions.newBuilder().setProjectId(proyecto_id).build().getService();
        BlobId blobId = BlobId.of(nombreBucket, nombreDeArchivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        if (pathArchivo!=null){
            System.out.println("ARCHIVO: "+pathArchivo);
            storage.create(blobInfo, Files.readAllBytes(Paths.get(pathArchivo)));
        }else{
            System.out.println("NO SE ENCUENTRA EL ARCHIVO");
        }

        System.out.println(
                "File " + pathArchivo + " uploaded to bucket " + nombreBucket + " as " + nombreDeArchivo);
    }

}
