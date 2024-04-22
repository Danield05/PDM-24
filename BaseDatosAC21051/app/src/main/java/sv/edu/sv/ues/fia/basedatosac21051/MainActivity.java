package sv.edu.sv.ues.fia.basedatosac21051;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

//TODO: Cambiar ListActivity a AppCompatActivity
public class MainActivity extends AppCompatActivity {
    String[] menu = {"Tabla Alumno", "Tabla Nota", "Tabla Materia", "LLenar Base de Datos"};
    String[] activities = {"AlumnoMenuActivity", "NotaMenuActivity", "MateriaMenuActivity"};
    ControlBDCarnet BDhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.menuList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                menu
        );
        listView.setAdapter(adapter);

        BDhelper = new ControlBDCarnet(this);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position != 3) {
                String nameValue = activities[position];

                try {
                    Class<?> aClass = Class.forName("sv.edu.sv.ues.fia.basedatosac21051." + nameValue);
                    Intent intent = new Intent(MainActivity.this, aClass);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                BDhelper.abrir();
                String toast = BDhelper.llenarBDCarnet();
                BDhelper.cerrar();
                Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
