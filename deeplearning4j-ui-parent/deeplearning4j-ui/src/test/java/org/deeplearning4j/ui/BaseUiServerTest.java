package org.deeplearning4j.ui;

import org.apache.commons.io.IOUtils;
import org.datavec.api.util.ClassPathResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author Adam Gibson
 */
public abstract class BaseUiServerTest {
    //    protected static UiServer uiServer;
    //    protected static Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class).register(new ObjectMapperProvider());

    @BeforeClass
    public static void before() throws Exception {
        ClassPathResource resource = new ClassPathResource("dropwizard.yml");
        InputStream is = resource.getInputStream();
        final File tmpConfig = new File("dropwizard-render.yml");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tmpConfig));
        IOUtils.copy(is, bos);
        bos.flush();
        bos.close();
        is.close();
        tmpConfig.deleteOnExit();
        //        uiServer = new UiServer();
        //        try {
        //            uiServer.run("server", tmpConfig.getAbsolutePath());
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
    }

    @AfterClass
    public static void after() {

    }

}
