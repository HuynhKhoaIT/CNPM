package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;
    public Cart(){
        items = new ArrayList<>();
    }
    public List<Item> getItems() {
        return items;
    }
    public int getQuantityById(int id){
        if(getItemById(id) !=null ){
            return getItemById(id).getQuantity();
        }
        else return 0;
    }
    private Item getItemById(int id){
        for(Item i:items) {
            if (i.getProduct().getMaSP() == id) {
                return i;
            }
        }
        return null;
    }
    public void addItem(Item t){
        if(getItemById(t.getProduct().getMaSP())!=null){
            Item m = getItemById(t.getProduct().getMaSP());
            m.setQuantity(m.getQuantity()+t.getQuantity());
        }else
            items.add(t);
    }
    public void removeItem(int id){
        if(getItemById(id)!=null){
            items.remove(getItemById(id));
        }
    }
    public int getTotalMoney(){
        int t = 0;
        for(Item i:items)
        {
            t+=(i.getQuantity()*i.getPrice());
        }
        return t;
    }
    public int getFirstMoney(){
        int t = 0;
        for(Item i:items)
        {
            t+=(i.getQuantity()*i.getProduct().getGiaBanThuong());
        }
        return t;
    }
    private  SanPham getProductById(int id,List<SanPham> list){
        for(SanPham i:list){
            if(i.getMaSP()==id){
                return i;
            }
        }
        return null;
    }
    public Cart(String txt, List<SanPham> list){
        items = new ArrayList<>();
        try{
            if(txt!=null && txt.length()!=0){
                String[] s =txt.split("#");
                for(String i:s){
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    SanPham p = getProductById(id,list);
                    Item t = new Item(p,quantity,p.getGiaKhuyenMai());
                    addItem(t);
                }
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
