package de.dasanten.yourdrinkgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the @link PlayerAdding#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerAdding extends Fragment implements View.OnClickListener {

    private NavController navController = null;
    private TextInputEditText textInputEditText;


    public PlayerAdding() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_adding, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.start_game_button).setOnClickListener(this);
        view.findViewById(R.id.add_player_button).setOnClickListener(this);
        textInputEditText = view.findViewById(R.id.set_player_input);
    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
            case  R.id.start_game_button:
                if (!TextUtils.isEmpty(textInputEditText.getText().toString())){
                    System.out.println("-----------------"+textInputEditText.getText());
                    ArrayList<String> name = new ArrayList<>();
                    name.add(textInputEditText.getText().toString());
                    name.add("Daniel");
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("player", name);
                    navController.navigate(R.id.action_playerAdding_to_cardDisplay, bundle);
                }else {
                    Toast.makeText(getActivity(), "Enter a name", Toast.LENGTH_SHORT).show();
                }

                break;
            case  R.id.add_player_button:
                break;

        }
    }
}
