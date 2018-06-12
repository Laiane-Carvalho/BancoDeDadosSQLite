package testeadapt3.cursoandroid2.com.bancodedados;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bancoDadosBase = openOrCreateDatabase("MeuApp",MODE_PRIVATE,null); // criamos o banco

            bancoDadosBase.execSQL("CREATE TABLE IF NOT EXISTS cadastroFamilia (nome VARCHAR , idade INT(3))"); //criamos a tabela

//            bancoDadosBase.execSQL("INSERT INTO cadastroFamilia (nome, idade) values ('Laiane Carvalho de oliveira', 28) ");// inserimos os dados
//            bancoDadosBase.execSQL("INSERT INTO cadastroFamilia (nome, idade) values ('Lara Carvalho de oliveira', 26) ");
//            bancoDadosBase.execSQL("INSERT INTO cadastroFamilia (nome, idade) values ('Larissa Carvalho de oliveira', 30) ");

            bancoDadosBase.execSQL("DELETE FROM cadastroFamilia WHERE  nome = 'Laiane Carvalho de oliveira' ");


            Cursor cursor = bancoDadosBase.rawQuery("SELECT nome ,idade FROM cadastroFamilia",null);// vamos ler os dados

            int indiceNome = cursor.getColumnIndex("nome"); // indicamos o indice nome e idade
            int indiceIdade = cursor.getColumnIndex("idade");


            cursor.moveToFirst(); // comecamos a ler do inicio

            while (cursor != null){ // enquanto o cursor n for nulo vamos ler

                Log.i("LogX",cursor.getString(indiceNome));
                Log.i("LogX",cursor.getString(indiceIdade));
                cursor.moveToNext(); // cursor leu e foi para proxima linha, ate que encontre uma linha vazia e saia do laço

            }

        }catch (Exception e){

            e.printStackTrace();
        }



    }

}
