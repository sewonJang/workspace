/*
	������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�, ������ ���� ���ɼ��� �����صΰ� ������ ������ �̹��� �������� ���� ���� �غ���.
	
*/
package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon {
	public MyIcon(URL url, int width, int height) {
		super(url);

		Image scaledImg = this.getImage();
		// ũ�⸦ �� ������ �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setImage(result);
	}
}
