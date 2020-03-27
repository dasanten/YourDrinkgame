package de.dasanten.yourdrinkgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Menu extends Fragment implements View.OnClickListener {


    public NavController navController = null;

    public Menu(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.start_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case  R.id.start_button:
                navController.navigate(R.id.action_menu_to_playerAdding);
            break;

        }
    }
}
