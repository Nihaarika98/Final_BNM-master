package manukj.manu.final_bnm;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_BNM extends Fragment {
    Activity activity1;
    ImageView imageView;


    public About_BNM() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity1 = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about__bnm, container, false);
    }
    public void onStart() {

        super.onStart();
        TextView textView = activity1.findViewById(R.id.about_bnm);
        imageView = activity1.findViewById(R.id.BNmit_Images);
        final int arr[] = {R.drawable.first,R.drawable.second,R.drawable.tird};
        TextView textView1 = activity1.findViewById(R.id.about_mba);
        textView1.setText("Established in 2006, Department of MBA-BNMIT has recorded consistently excellent academic performance by securing top ranks in VTU.  International and national level faculty Research Contributions, Memorandums of Understanding with University of Alabama in Huntsville, USA, Republic of Belarus, Eastern Europe, Fidelity National Financial Ltd., Learninto Edu Pvt. Ltd., and IIMBx, National level student fests, conferences, online courses, Industry Interface programs are the prominent features of the Department. ED Cell of BNMIT has received a grant of Rs. 2.87 crore under New Gen-IEDC from DST, Government of India for students to develop products.");

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                imageView.setImageResource(arr[i]);
                i++;
                if(i > arr.length -1)
                { i = 0 ;}
                handler.postDelayed(this,2000);
            }
        };
        handler.postDelayed(runnable,2000);

        textView.setText("B.N.M. Institute of Technology (also Bhageerathi Bai Narayana Rao Maanay Institute of Technology) is a private technical co-educational school located in Banshankari 2nd Stage, Bangalore, Karnataka, India. It was established in 2001 and is affiliated to the Visvesvaraya Technological University, Belgaum.[1] It is a part of BNMEI (BNM Educational Institutions) established by the Trust M/s. Bhageerathi Bai Narayana Randi Maanay Charities, started in 1972. BNMIT is an approved ISO 9001:2008 Certified Institute (TUVRheinland).");
            }

}
