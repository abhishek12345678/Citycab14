package dcom.citycab14;

import android.graphics.Bitmap;
import android.widget.Toast;

public class Home {

    PlaceAutocompleteFragment place_location,place_destination;
    String  mPlaceLocation,mPlaceDestination;

    place_destination = (PlaceAutocompleteFragment)getFragmentManager().findFragmentById(R.id.place_destination);
    place_location = (PlaceAutocompleteFragment)getFragmentManager().findFragmentById(R.id.place_location);

    place_location.setOnPlaceSelectedListener(new PLaceSelectionListener())
    {
        public void onPlaceSelected(Place place)
        {
            mPlaceLocation = place.getAddress().toString();
            mMap.clear();

            mUserMarker = mMap.addMarker(new MarkerOptions().position(place.getLatLng())
            .title("Pickup Here")
            .icon(BitmapDescriptorFactory.defaultMarker()));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(),15.0f));


        }
    }

    place_destination.setOnPlaceSelectedListener(new PlaceSelectedListener())
    {
        public void onPlaceSelected(Place place)
        {

            mPlaceDestination = place.getAddress().toString();
            nMap.addMarker(new MarkerOptions().position(Place.getLatLng())
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(),15.0f));

            BottomSheetRiderFragment mBottomSheet = BottomSheetRiderFragment.newInstance(mPlaceLocation,mPlaceDestination);

            mBottomSheet.show(getSupportFragmentManager(),mBottomSheet.getTag());





        }
        public void onError(Status status)
        {

        }
    }

    private void loadAllAvailableDriver(LatLng location)
    {
        mMap.addMarker(new MarkerOptions().position (location)
          .title("you"));

        GeoQuary geoQuary=gf.queryAtLocation(new GeoLocation(location.latitude,location.longitude),distance);

    }

    public void onGeoQueryReady()
    {
        if(distance <= LIMIT)
        {
            distance++;
            loadAllAvailableDriver(location);
        }
    }

    public void onDataChange(DataSnapshot dataSnapshot)
    {
        loadAllAvailableDriver(new  LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));


    }

    private void  findDriver()
    {
        public void onGeoQueryReady()
        {
            if( !isDriverFound  && radius < LIMIT)
            {
                radius++;
                findDriver();
            }
            else
            {
                Toast.makeText(Home.this,"No available any driver near you",Toast.LENGTH_LONG).show();
                btnPickupRequest.setText("REQUEST PICKUP");

            }
        }
    }








}
