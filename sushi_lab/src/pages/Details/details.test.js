import { fireEvent, render, screen } from "@testing-library/react"
import Details from ".";


const oneProductMock = {
  "id": 1,
  name: 'Product 1',
  description: 'This is a test product',
  image: 'product1.jpg',
  price: 9.99,
  priceFormatted: '$9.99',
}

jest.mock("react-router-dom", () => ({
  ...jest.requireActual("react-router-dom"),
  useLocation: () => ({
    state: { ...oneProductMock }
  })
}));

describe('Teste da tela Detalhes',  () => {

  it('Deve renderizar os principais elementos da tela quando houve desconto', () => {
    render(<Details />)

    expect(screen.getByRole('img')).toHaveAttribute('src', oneProductMock.image)
    expect(screen.getByText(oneProductMock.name)).toBeInTheDocument()
    expect(screen.getByText(oneProductMock.priceFormatted)).toBeInTheDocument()

    expect(screen.getByTestId('amount-product').textContent).toEqual("1")

  })

  it('Deve exibir a quantidade correta ao interagir com os botões' , () => {

    render(<Details />)

    const buttonIncrement = screen.getByTestId('increment-button')
    const buttonDecrement = screen.getByTestId('decrement-button')

    fireEvent.click(buttonIncrement)
    fireEvent.click(buttonIncrement)
    fireEvent.click(buttonIncrement)

    expect(screen.getByTestId('amount-product').textContent).toEqual("4")

    fireEvent.click(buttonDecrement)
    fireEvent.click(buttonDecrement)

    expect(screen.getByTestId('amount-product').textContent).toEqual("2")
  })


  it('Deve desabilitar a quantidade quando quantidade igual 1', () => {

    render(<Details />)

    const buttonIncrement = screen.getByTestId('increment-button')
    const buttonDecrement = screen.getByTestId('decrement-button')

    fireEvent.click(buttonIncrement)
    fireEvent.click(buttonIncrement)

    fireEvent.click(buttonDecrement)
    fireEvent.click(buttonDecrement)

    expect(screen.getByTestId('amount-product').textContent).toEqual("1")
    expect(buttonDecrement).toBeDisabled()
    expect(buttonIncrement).not.toBeDisabled()
  })

})