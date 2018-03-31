package business;

import domain.Material;
import file.MaterialFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaterialBusiness {

    private MaterialFile materialFile;

    public MaterialBusiness() {
        this.materialFile = new MaterialFile();
    } // constructor

    public void addMaterial(Material material, int type) throws IOException, ClassNotFoundException {
        //type 1= Other
        if (type == 1) {
            material.setCode(materialFile.getCodeMaterial());
        } else if (type == 2) {
            material.setCode(materialFile.getISBNBook());
        }
        materialFile.addMaterial(material);
    } // addMaterial
    
    public List<ArrayList> getBooksAndAudiovisual() throws IOException, ClassNotFoundException{
        return materialFile.getBooksAndAudiovisual();
    } //

    public void addBookExixting(int code, int quantity) throws IOException, ClassNotFoundException{
        materialFile.addBookExixting(code, quantity);
    } // addBookExixting
    
} // fin de la clase
