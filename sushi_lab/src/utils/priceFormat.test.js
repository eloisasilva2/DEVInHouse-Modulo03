import {priceFormat} from "./priceFormat"

describe("Testando a função de formato do preço", () => {

    it('Deve retornar o preço formatado', () =>{

        const result = priceFormat(100)

        expect(result).toBe("R$100,00")

    })

})