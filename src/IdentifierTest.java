import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTest {

    private Identifier id;

    public IdentifierTest() {
        this.id = new Identifier();
    }


    /**
     * Verifica se um identificador com apenas um caractere alfabético é considerado válido.
     * Este é um caso de limite mínimo para um identificador válido e cobre os critérios 1, 2 e 3.
     */
    @Test
    void testSingleCharacterValidIdentifiers() {
        assertTrue(this.id.validateIdentifier("A"));
    }

    /**
     * Testa uma string vazia, que deve ser inválida, pois não atende ao requisito de comprimento mínimo.
     * Este teste cobre um caso de limite inferior para o comprimento e cobre os critérios 1 e 2 negativamente.
     */
    @Test
    void testInvalidIdentifierDueToEmptyString() {
        assertFalse(this.id.validateIdentifier(""));
    }


    /**
     * Verifica um identificador que começa com um dígito. Esse caso é inválido,
     * pois o primeiro caractere não é uma letra. Este caso cobre o critério 1 negativamente.
     */
    @Test
    void testInvalidIdentifierStartingWithDigit() {
        assertFalse(this.id.validateIdentifier("9"));
    }

    /**
     * Testa um identificador que excede o comprimento máximo permitido (mais de 6 caracteres).
     * Este caso de limite superior cobre o critério 2 negativamente.
     */
    @Test
    void testInvalidSizeIdentifier() {
        assertFalse(this.id.validateIdentifier("A1234567"));
    }

    /**
     *  Verifica um identificador com o comprimento máximo permitido (6 caracteres)
     *  e que atende aos critérios de caracteres válidos.
     *  Este caso cobre os critérios 1, 2 e 3 positivamente.
     */
    @Test
    void testValidSizeIdentifier() {
        assertTrue(this.id.validateIdentifier("A12345"));
    }

    /**
     * Testa um identificador que contém um caractere especial ($).
     * Esse identificador é inválido, pois apenas letras e dígitos são permitidos.
     * Este teste cobre o critério 3 negativamente.
     */
    @Test
    void specialCaracters(){
        assertFalse(this.id.validateIdentifier("A12345$"));
    }

}