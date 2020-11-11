package com.user.project.userApp.services;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.user.project.userApp.entities.Address;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeoCoder {

    public Geometry getGeolocation(Address address)  {
        try {
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey("Enter your GoogleMaps API Key HERE")
                    .build();
            GeocodingResult[] results;
            results = GeocodingApi.geocode(context,
                    new StringBuilder().append(address.getAddressLine()).append(" ")
                            .append(address.getAddressNo()).append(", ")
                            .append(address.getCity()).append(", ")
                            .append(address.getZipCode()).toString()).await();
          if(results.length>0){
            Geometry geo=   results[0].geometry;
            return geo;
          }
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
