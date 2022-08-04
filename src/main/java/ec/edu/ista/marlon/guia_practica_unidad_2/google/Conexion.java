package ec.edu.ista.marlon.guia_practica_unidad_2.google;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Conexion {

    public void subirArchivo(/*String projectId, String bucketName, String objectName, String filePath*/) throws IOException {
        // The ID of your GCP project
         String projectId_p = "durable-sound-356201";

        // The ID of your GCS bucket
         String bucketName_p = "guia_bucket_tendencias";

        // The ID of your GCS object
         String objectName_p = "moodboard_prueba";

        // The path to your file to upload
         //String filePath_p = String.valueOf(Conexion.class.getResource("analisis.gif"));
         String filePath_p ="C:\\Users\\velez\\Documents\\IntelliJ Projects\\Guia_Practica_Unidad_2\\src\\main\\resources\\ec\\edu\\ista\\marlon\\moodboard.pdf";

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId_p).build().getService();
        BlobId blobId = BlobId.of(bucketName_p, objectName_p);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        if (filePath_p!=null){
            System.out.println("ARCHIVO: "+filePath_p);
            storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath_p)));
        }else{
            System.out.println("NO SE ENCUENTRA EL ARCHIVO");
        }

        System.out.println(
                "File " + filePath_p + " uploaded to bucket " + bucketName_p + " as " + objectName_p);
    }

}
