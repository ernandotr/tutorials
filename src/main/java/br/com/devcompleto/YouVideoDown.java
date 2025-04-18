package br.com.devcompleto;

import com.github.axet.vget.VGet;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class YouVideoDown {

    public static void main(String[] args) {
        String url = "https://www.youtube.com/watch?v=19xwjgsC_58";

        String paht = "/Users/ernandorezende/Movies/youtube/";

        try {
            VGet vGet = new VGet(new URI(url).toURL(), new File( paht));
            System.out.println(vGet.getVideo());
            vGet.download();
            System.out.println("Vdeo downloaded successful.");
        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
