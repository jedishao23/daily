package com.bjsxt.io.pattern;
/**
 * ������
 * ������֮��Ĺ�ϵ
 * 1������:�β�|�ֲ�����
 * 2������:����
 * 		�ۺ�:���� �����벿�� ��һ�µ��������� ������
 *      ���:���� �����벿�� һ�µ���������  �������
 * 3���̳�:�������ϵ
 * 4��ʵ��: �ӿ���ʵ�����ϵ
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Amplifier {
	private Voice voice;
	public Amplifier() {
	}
	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	
	public void say(){
		System.out.println(voice.getVoice()*1000);
	}
}
