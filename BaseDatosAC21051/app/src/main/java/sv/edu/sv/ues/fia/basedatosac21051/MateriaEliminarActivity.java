package sv.edu.sv.ues.fia.basedatosac21051;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaEliminarActivity extends Activity {
    EditText editCodmateria;

    ControlBDCarnet controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_eliminar);
        controlhelper=new ControlBDCarnet(this);
        editCodmateria=(EditText)findViewById(R.id.editCodmateria);
    }
    public void eliminarMateria(View v){
        String regEliminadas;
        Materia materia=new Materia();
        materia.setCodmateria(editCodmateria.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(materia);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void limpiar(View v){
        editCodmateria.setText("");
    }
}
