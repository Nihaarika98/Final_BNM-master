package manukj.manu.final_bnm;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    Activity context;
    ImageView Annihilation,Cease_Fire,Maneuver,Manstein_plan,Blitzkrieg,Polarity;
    TextView date;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }
    public void onStart() {

        super.onStart();
        Polarity =  context.findViewById(R.id.Polarity);
        Annihilation = context.findViewById(R.id.Annihilation);
        Cease_Fire = context.findViewById(R.id.Cease_Fire);
        Maneuver = context.findViewById(R.id.Maneuver);
        Manstein_plan = context.findViewById(R.id.Manstein_plan);
        Blitzkrieg = context.findViewById(R.id.Blitzkrieg);
        date = context.findViewById(R.id.date);
        date.setText("APRIL\n27th-28th\n2018");
        Blitzkrieg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Event.class);
                intent.putExtra("Event",1);
                startActivity(intent);
            }
        });

        Manstein_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Event.class);
                intent.putExtra("Event",2);
                startActivity(intent);
            }
        });
        Maneuver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Event.class);
                intent.putExtra("Event",3);
                startActivity(intent);
            }
        });
        Cease_Fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Event.class);
                intent.putExtra("Event",4);
                startActivity(intent);
            }
        });
        Annihilation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Event.class);
                intent.putExtra("Event",5);
                startActivity(intent);
            }
        });
        Polarity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Event.class);
                intent.putExtra("Event",6);
                startActivity(intent);
            }
        });
    }

}
