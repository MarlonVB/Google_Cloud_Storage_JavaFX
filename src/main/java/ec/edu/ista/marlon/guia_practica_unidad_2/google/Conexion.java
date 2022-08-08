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

    public void subirArchivo(String proyecto_id, String nombreBucket, String nombreDeArchivo, String pathArchivo) throws IOException {
        long inicio = System.currentTimeMillis();
        Storage storage = StorageOptions.newBuilder().setProjectId(proyecto_id).build().getService();
        BlobId blobId = BlobId.of(nombreBucket, nombreDeArchivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        if (pathArchivo!=null){
            storage.create(blobInfo, Files.readAllBytes(Paths.get(pathArchivo)));
        }else{
            System.out.println("NO SE ENCUENTRA EL ARCHIVO");
        }
        long fin = System.currentTimeMillis();


        System.out.println("INICIO: "+inicio);
        System.out.println("FIN: "+fin);
        System.out.println(
                "File " + pathArchivo + " uploaded to bucket " + nombreBucket + " as " + nombreDeArchivo+" \n Tiempo de Espera: "+(fin - inicio)/1000);

    }

}
