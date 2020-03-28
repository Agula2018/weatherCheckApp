package com.agnieszka.piotrowska.weatherCheckApp.util;

import com.agnieszka.piotrowska.weatherCheckApp.model.request.NearestInstallationRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLUtilTest {

    @Test
    void getURLParams() {
        String expected = "?lat=50.062006&lng=19.940984&maxDistanceKm=3&maxResults=1";
        NearestInstallationRequest req = NearestInstallationRequest.builder()
                .lat(50.062006)
                .lng(19.940984)
                .maxDistanceKm(3)
                .maxResults(1)
                .build();

        Assert.assertEquals(expected, URLUtil.getURLParams(req, true));
    }
}