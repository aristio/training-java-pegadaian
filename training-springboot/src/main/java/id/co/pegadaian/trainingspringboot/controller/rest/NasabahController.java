package id.co.pegadaian.trainingspringboot.controller.rest;

import id.co.pegadaian.trainingspringboot.dao.NasabahDao;
import id.co.pegadaian.trainingspringboot.entity.Nasabah;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasabahController {
    
    @Autowired
    private NasabahDao nasabahDao;
    
    @PostMapping("/nasabah/simpan")
    public void simpanNasabah(@RequestBody Nasabah n){
        
        System.out.println("masuk ke simpan");
        System.out.println("id "+n.getId());
        System.out.println("nama "+n.getNama());
        System.out.println("alamat "+n.getAlamat());
        
        nasabahDao.save(n);
    } 
    
    public List<Nasabah> cariSemuaNasabah(){
        List<Nasabah> semuaNasabah = (List<Nasabah>) nasabahDao.findAll();
        return semuaNasabah;
    }
    
    public Nasabah cariNasabahById(String id){
        Nasabah nasabah = nasabahDao.findById(id).get();
        return nasabah;
    }
    
    public List<Nasabah> cariNasabahByNama(String nama){
        
        List<Nasabah> list = nasabahDao.findByNama(nama);
        return list;
    }
    
    public void deleteNasabah(){
    
    }
    
}

