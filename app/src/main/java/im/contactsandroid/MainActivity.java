package im.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{
    ArrayAdapter<String> items;

    EditText addName;
    EditText addPhone;
    Button enterButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addName = (EditText) findViewById(R.id.addName);
        addPhone = (EditText) findViewById(R.id.addPhone);
        enterButton = (Button) findViewById(R.id.enterButton);
        listView = (ListView) findViewById(R.id.listView);

        enterButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(items);
    }


    @Override
    public void onClick(View v) {
        String text = addName.getText().toString();
        String phone = addPhone.getText().toString();
        items.add(String.format("%s (%s)", text, phone));
        addName.setText("");

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(items.getItem(position));
        return true;
    }
}
