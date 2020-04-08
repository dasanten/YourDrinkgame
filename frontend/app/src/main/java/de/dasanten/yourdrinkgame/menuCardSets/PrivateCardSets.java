package de.dasanten.yourdrinkgame.menuCardSets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.dasanten.yourdrinkgame.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrivateCardSets#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrivateCardSets extends Fragment {


    public PrivateCardSets() {
        // Required empty public constructor
    }

    public static PrivateCardSets newInstance(String param1, String param2) {
        PrivateCardSets fragment = new PrivateCardSets();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_private_card_sets, container, false);
    }
}
