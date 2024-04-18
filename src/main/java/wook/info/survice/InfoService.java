package wook.info.survice;

import java.util.ArrayList;

import wook.info.dto.InfoDTO;

public interface InfoService {
  public ArrayList<InfoDTO> infoSelect();
  
  public InfoDTO infoSelectDetail(int info_Number);
  
  public InfoDTO infoInsert(InfoDTO infoDTO);
  
  public InfoDTO infoUpdate(InfoDTO infoDTO);
  
  public InfoDTO infoDelete(int info_Number);
  
  public void infoCounting(int info_Number);
  
}
