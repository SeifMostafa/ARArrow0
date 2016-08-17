package seifmostafa.myartest0;


import com.threed.jpct.Loader;
import com.threed.jpct.Matrix;
import com.threed.jpct.Object3D;
import com.threed.jpct.SimpleVector;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by seifmostafa on 17/08/16.
 */
public class Utility {
    public static Object3D loadModel(String filename, String filenameAssistant , float scale) throws UnsupportedEncodingException {

        InputStream stream = new ByteArrayInputStream(filename.getBytes("UTF-8"));
        InputStream streamAssistant = new ByteArrayInputStream(filenameAssistant.getBytes("UTF-8"));

        Object3D[] model = Loader.loadOBJ(stream,streamAssistant, scale);
        Object3D obj = new Object3D(0);
        Object3D temp = null;
        for (int i = 0; i < model.length; i++) {
            temp = model[i];
            temp.setCenter(SimpleVector.ORIGIN);
            temp.rotateX((float)( -.5*Math.PI));
            temp.rotateMesh();
            temp.setRotationMatrix(new Matrix());
            obj = Object3D.mergeObjects(obj, temp);
            obj.build();
        }
        return obj;
    }
    // implement onTouchEvent for rotate object 3d
}
