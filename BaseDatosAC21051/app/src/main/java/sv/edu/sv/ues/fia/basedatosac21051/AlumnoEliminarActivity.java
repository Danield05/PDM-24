package sv.edu.sv.ues.fia.basedatosac21051;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlumnoEliminarActivity extends Activity {
    EditText editCarnet;  ControlBDCarnet controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_eliminar);
        controlhelper=new ControlBDCarnet (this);
        editCarnet=(EditText)findViewById(R.id.editCarnet);
    }
    public void eliminarAlumno(View v){
        String regEliminadas;
        Alumno alumno=new Alumno();
        alumno.setCarnet(editCarnet.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(alumno);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}