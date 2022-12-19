package com.Study.tank.Test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ������
 * @version 1.0
 */
 class ImageTest {//������
    @Test
    void test(){
        try {
            //BufferedImage image = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\��ֽ\\�½��ļ���\\Win11.png"));//����·������ζ��ʹ����Ŀ¼��ҲҪ�е�ǰ�ļ�
            BufferedImage image = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\��ֽ\\�½��ļ���\\Win11.png"));//��ȡĿ¼�µ�ͼƬ�ļ�
            assertNotNull(image);//�ļ����ǿ� ����ͨ��

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            //getClassLoader����Class�ļ���ȡ��ResourceAsStream �ڽ���IO ��ȡͼƬ
            assertNotNull(image2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //fail("Not yet implemented");//����ʧ��
        //Assertions ����
        //assertNotNull(new Object());//�����������ݲ��ǿ�ֵ
    }
}
