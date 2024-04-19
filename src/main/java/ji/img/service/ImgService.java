package ji.img.service;

import java.util.ArrayList;

import ji.img.dto.ImgDTO;

public interface ImgService {
	public ArrayList<ImgDTO> imgSelectAll();
	
	public ImgDTO imgSelect(int img_number);
	public ImgDTO imgInsert(ImgDTO imgDTO);
	public ImgDTO imgUpdate(ImgDTO imgDTO);
	public ImgDTO imgDelete(int img_number);
}
