package sv.edu.sv.ues.fia.basedatosac21051;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlumnoMenuActivity extends AppCompatActivity {
    String[] menu = {"Insertar Registro", "Eliminar Registro", "Consultar Registro", "Actualizar Registro"};
    String[] activities = {"AlumnoInsertarActivity", "AlumnoEliminarActivity", "AlumnoConsultarActivity", "AlumnoActualizarActivity"};
    ControlBDCarnet BDhelper;
    int selectedItem = -1; // Variable para almacenar el elemento seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_menu);

        ListView listView = findViewById(R.id.menuListAlumno);
        listView.setBackgroundColor(Color.rgb(0, 191, 255));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(adapter);

        // Restaurar el elemento seleccionado si existe
        if (savedInstanceState != null) {
            selectedItem = savedInstanceState.getInt("selectedItem", -1);
            if (selectedItem != -1) {
                listView.getChildAt(selectedItem).setBackgroundColor(Color.rgb(128, 128, 255));
            }
        }

        BDhelper = new ControlBDCarnet(this);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position != 4) {
                String nameValue = activities[position];
                view.setBackgroundColor(Color.rgb(128, 128, 255));
                selectedItem = position; // Guardar el elemento seleccionado

                try {
                    Class<?> aClass = Class.forName("sv.edu.sv.ues.fia.basedatosac21051." + nameValue);
                    Intent intent = new Intent(AlumnoMenuActivity.this, aClass);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selectedItem", selectedItem);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = findViewById(R.id.menuListAlumno);
        if (selectedItem != -1) {
            listView.getChildAt(selectedItem).setBackgroundColor(Color.TRANSPARENT);
            selectedItem = -1;
        }
    }
}
