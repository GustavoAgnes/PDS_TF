import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {
    @Test
    public void testeUsuarioValido(){
        DBConnection db = new DBConnection(); // 0 = usuario invalido, 1 = valido, 2 = bloqueado
        assertEquals(1,db.validarUsuario("teste","teste"));
    }

    @Test
    public void testeUsuarioInexistente(){
        DBConnection db = new DBConnection(); // 0 = usuario invalido, 1 = valido, 2 = bloqueado
        assertEquals(0,db.validarUsuario("testeNaoExiste","teste"));
    }

    @Test
    public void testeSenhaIncorreta(){
        DBConnection db = new DBConnection(); // 0 = usuario invalido, 1 = valido, 2 = bloqueado
        assertEquals(0,db.validarUsuario("teste","teste2"));
    }

    @Test
    public void testeUsuarioBloqueado(){
        DBConnection db = new DBConnection(); // 0 = usuario invalido, 1 = valido, 2 = bloqueado
        db.validarUsuario("errado","errado");
        db.validarUsuario("errado","errado");
        db.validarUsuario("errado","errado");
        assertEquals(2,db.validarUsuario("errado","errado"));
    }
}
