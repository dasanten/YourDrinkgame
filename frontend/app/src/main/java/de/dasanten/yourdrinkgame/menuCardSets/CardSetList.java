package de.dasanten.yourdrinkgame.menuCardSets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import de.dasanten.yourdrinkgame.R;
import de.dasanten.yourdrinkgame.localDataBase.CardSetRepository;
import de.dasanten.yourdrinkgame.localDataBase.CardSetViewModel;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;


public class CardSetList extends Fragment implements View.OnClickListener {




    private CardSetRepository cardSetViewModel;
    public CardSetList() {
        // Required empty public constructor
    }


    public static CardSetList newInstance(String param1, String param2) {
        CardSetList fragment = new CardSetList();
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
        View view = inflater.inflate(R.layout.fragment_card_set_list, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager_card_sets);
        setupWithViewPager(viewPager);
        TabLayout tabs = (TabLayout) view.findViewById(R.id.card_set_tabs);
        tabs.setupWithViewPager(viewPager);
        setupTabIcons(tabs);
        return view;
    }

    private void setupTabIcons(TabLayout tabLayout){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_folder_orange_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_wifi_orange_24dp);
    }

    private void setupWithViewPager(ViewPager viewPager) {
        PageAdapter pageAdapter = new PageAdapter(getChildFragmentManager());
        pageAdapter.addFragment(new PrivateCardSets(), "Privat");
        pageAdapter.addFragment(new GlobalCardSets(), "Workshop");
        viewPager.setAdapter(pageAdapter);
    }




    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    public void onClick(View v) {

    }
}
