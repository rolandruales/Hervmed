package com.example.hervmed2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentCommon extends Fragment implements HerbAdapter.OnNoteListenerHerb{

    ArrayList<HerbItems> herbItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recyclerview_container, container, false);

        RecyclerView popularRecView = view.findViewById(R.id.reyclerViewContainer);
        popularRecView.setLayoutManager(new LinearLayoutManager(getContext()));
        HerbAdapter hAdapter = new HerbAdapter(initHerb(), this);
        popularRecView.setAdapter(hAdapter);

        return view;
    }

    private ArrayList<HerbItems> initHerb(){
        herbItems.add(new HerbItems(R.drawable.bael, "Bael", "Aegle marmelos", R.string.bael_content));
        herbItems.add(new HerbItems(R.drawable.catnip, "Catnip", "Nepeta cataria", R.string.catnip_content));
        herbItems.add(new HerbItems(R.drawable.cinnamon, "Cinnamon", "Cinnamomum verum",R.string.cinnamon_content));
        herbItems.add(new HerbItems(R.drawable.henna, "Henna", "Lawsonia inermis", R.string.henna_content));
        herbItems.add(new HerbItems(R.drawable.lavender, "Lavender", "Tagetes", R.string.lavender_content));
        herbItems.add(new HerbItems(R.drawable.marigold, "Marigold", "Perilla frutescens var. crispa", R.string.marigold_content));
        herbItems.add(new HerbItems(R.drawable.neem, "Neem", "Azadirachta indica",R.string.neem_content));
        herbItems.add(new HerbItems(R.drawable.peppermint, "Peppermint", "Mentha × piperita", R.string.peppermint_content));
        herbItems.add(new HerbItems(R.drawable.rosemary, "Rosemary", "Salvia rosmarinus",R.string.rosemary_content));


        return herbItems;
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getActivity(), InformationActivity.class);
        intent.putExtra("Example", herbItems.get(position));


        startActivity(intent);
    }
}