package manukj.manu.final_bnm;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_MBA extends Fragment {
Activity activity;

    public About_MBA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about__mb, container, false);
    }
    public void onStart() {

        super.onStart();
        TextView textView = activity.findViewById(R.id.details);
        textView.setText("\nPost Box No. 7087,\n12th Main Road, 27th Cross,\nBanashankari II Stage,\n" + "Bangalore – 560 070. \n" + "\n");
    }

}
