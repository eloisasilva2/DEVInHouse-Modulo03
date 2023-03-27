import { render, fireEvent, screen } from '@testing-library/react';
import ProductCard from '.'

const product = {
  id: 1,
  name: 'Product 1',
  description: 'This is a test product',
  image: 'product1.jpg',
  price: 9.99,
  priceFormatted: '$9.99',
};

const mockedNavigate = jest.fn();

jest.mock("react-router-dom", () => ({
  useNavigate: () => mockedNavigate,
}));

describe('Teste do componente de ProductCard', () => {
  
  it('Deve renderizar o componente com as principais informações', () => {
    render(<ProductCard product={product} />)

    expect(screen.getByRole('img')).toHaveAttribute('src', product.image)

    expect(screen.getByText(product.name)).toBeInTheDocument()
    expect(screen.getByText(product.priceFormatted)).toBeInTheDocument()
  })

  it('Deve chamar disparar o evento de onClick ao clicar no card', () => {
    render(<ProductCard product={product} />)

    const button = screen.getByText(/Ver Detalhes/i)

    fireEvent.click(button)

    expect(mockedNavigate).toBeCalled()
    expect(mockedNavigate).toBeCalledTimes(1)
  })

})