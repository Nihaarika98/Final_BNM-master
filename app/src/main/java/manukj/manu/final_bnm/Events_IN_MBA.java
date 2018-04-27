package manukj.manu.final_bnm;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Events_IN_MBA extends Fragment {
    Button aarohan,current_Events,exal;
    Activity activity;
    public Events_IN_MBA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events__in__mb, container, false);
    }

    public void onStart() {

        super.onStart();
        aarohan = activity.findViewById(R.id.aarohan_from_events);
        Button past_Events = activity.findViewById(R.id.past_event);
        current_Events = activity.findViewById(R.id.Current_events);
        exal = activity.findViewById(R.id.excel_workshop);
        past_Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aarohan.setVisibility(View.GONE);
                exal.setVisibility(View.VISIBLE);
            }
        });
        aarohan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,Splash_Screen.class);
                startActivity(intent);
            }
        });
        exal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        current_Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aarohan.setVisibility(View.VISIBLE);
                exal.setVisibility(View.GONE);
            }
        });
    }

}
