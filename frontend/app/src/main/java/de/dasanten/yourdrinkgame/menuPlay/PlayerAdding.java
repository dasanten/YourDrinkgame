package de.dasanten.yourdrinkgame.menuPlay;

import android.graphics.drawable.Drawable;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import de.dasanten.yourdrinkgame.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the @link PlayerAdding#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerAdding extends Fragment implements View.OnClickListener {

    private NavController navController = null;
    private TextInputEditText textInputEditText;
    private ChipGroup displyedPlayerList;
    private Button addPlayerButton;
    private ArrayList<String> name = new ArrayList<>();


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
        displyedPlayerList = view.findViewById(R.id.player_list);
        addPlayerButton = view.findViewById(R.id.add_player_button);
    }

    @Override
    public void onClick(View view){

        switch (view.getId()){
            case  R.id.start_game_button:
                if (!TextUtils.isEmpty(textInputEditText.getText().toString()) && name.size() >= 1 || name.size() >= 2 ){
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("player", name);
                    if (!TextUtils.isEmpty(textInputEditText.getText().toString())) {
                        name.add(textInputEditText.getText().toString());
                    }
                    navController.navigate(R.id.action_playerAdding_to_cardDisplay, bundle);
                }else {
                    Toast.makeText(getActivity(), "Geb mindestens 2 Namen ein" , Toast.LENGTH_SHORT).show();
                }
                break;
            case  R.id.add_player_button:
                if (!TextUtils.isEmpty(textInputEditText.getText().toString())){
                    name.add(textInputEditText.getText().toString());
                    final Chip chip = new Chip(displyedPlayerList.getContext());
                    Drawable d = getResources().getDrawable(R.drawable.ic_clear_black_24dp);
                    chip.setCloseIcon(d);
                    chip.setOnCloseIconClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            name.remove(chip.getText().toString());
                            displyedPlayerList.removeView(chip);
                        }
                    });
                    chip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            name.remove(chip.getText().toString());
                            displyedPlayerList.removeView(chip);
                        }
                    });

                    chip.setText(textInputEditText.getText().toString());
                    displyedPlayerList.addView(chip);
                }
                textInputEditText.setText(null);
                break;

        }
    }
}
