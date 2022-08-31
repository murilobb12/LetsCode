package com.letscode.ecommerce.endpoints;

import com.letscode.ecommerce.dao.ProdutosDao;
import com.letscode.ecommerce.models.Produtos;
import com.letscode.ecommerce.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutosEndpoints {

    @Autowired
    ProdutosService produtosService;

    @RequestMapping(path = "/produtos", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produtos>> getAllProducts(){
        List<Produtos> produtosList = produtosService.listarProdutos();

        return ResponseEntity.ok(produtosList);
    }


    @RequestMapping(path = "/produtos", method = RequestMethod.POST)
    public ResponseEntity criarProduto(@RequestBody Produtos _produtos){
        boolean sucesso = produtosService.novoProduto(_produtos);

        if (sucesso){
            return new ResponseEntity("Produto criado com sucesso!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity("Criação do produto não realizada", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produtos", method = RequestMethod.PUT)
    public ResponseEntity atualizarProduto(@RequestBody Produtos produtos){
        boolean sucesso = produtosService.atualizarProduto(produtos);

        if(sucesso){
            return new ResponseEntity("Produto atualizado com sucesso!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity("Atualização do produto não foi realizada!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removerProduto(@PathVariable long id){
        boolean sucesso = produtosService.removerProduto(id);

        if (sucesso){
            return new ResponseEntity("Produto deletado com sucesso!", HttpStatus.OK);
        }else {
            return new ResponseEntity("Deleção do produto não foi realizada", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity listarProduto(@PathVariable long id){
        Produtos produtos = produtosService.listarProduto(id);

        return ResponseEntity.ok(produtos);
    }


}
