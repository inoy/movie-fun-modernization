package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String url;
    private final RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> movieListType
            = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String url, RestOperations restOperations) {
        this.url = url;
        this.restOperations = restOperations;
    }

    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(url, album, AlbumInfo.class);
    }

    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(url, GET, null, movieListType).getBody();
    }

    public AlbumInfo find(long id) {
        return restOperations.getForObject(url + "/" + id, AlbumInfo.class);
    }
}
