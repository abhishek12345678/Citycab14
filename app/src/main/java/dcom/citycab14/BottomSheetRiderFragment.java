package dcom.citycab14;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BottomSheetRiderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BottomSheetRiderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomSheetRiderFragment extends Fragment {

    String mLocation,mDestination;

    public BottomSheetRiderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomSheetRiderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomSheetRiderFragment newInstance(String location, String destination) {

        BottomSheetRiderFragment f = new BottomSheetRiderFragment();
        Bundle args = new Bundle();
        args.putString("location", location );
        args.putString("destination", destination);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLocation = getArguments().getString("location");
        mDestination = getArguments().getString("destination");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_bottom_sheet_rider, container, false);
        TextView txtLocation=(TextView)view.findViewById(R.id.txtLocation);
        TextView txtDestination=(TextView)view.findViewById(R.id.txtDestination);
        TextView txtCalculate=(TextView)view.findViewById(R.id.txtCalculate);

        txtLocation.setText(mLocation);
        txtDestination.setText(mDestination);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
