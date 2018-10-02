package br.com.livroandroid.carros.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.livroandroid.carros.R;


public class CarrosFragment extends BaseFragment {

    private int tipo;

    public static CarrosFragment newInstance(int tipo){
        Bundle args = new Bundle();
        args.putInt("tipo", tipo);
        CarrosFragment frags = new CarrosFragment();
        frags.setArguments(args);
        return frags;
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //le o tipo dos argumentos
        if(getArguments() != null) {
            this.tipo = getArguments().getInt("tipo");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_carros, container, false);
        TextView text = (TextView) view.findViewById(R.id.text);
        text.setText("Carros" + getString(tipo));

        return view;
    }





}
