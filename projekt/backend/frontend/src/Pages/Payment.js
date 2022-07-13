import { Elements } from "@stripe/react-stripe-js"
import { loadStripe } from "@stripe/stripe-js"
import PaymentForm from "../Components/PaymentComponent"

const Payment = () => {
    const publishable_key = 'pk_test_51LJbvHE19vO0UQxEAdTcbSrIJlnYsaz85I99wKeqeiRluIi62TwwxfN4vvtL6AZyRyMYcCw1JC79Y3K7YcHjNtFM00zOGB3vNF'
    const stripeTestLoad = loadStripe(publishable_key)

    return (
        <Elements stripe={stripeTestLoad}>
            <PaymentForm />
        </Elements>
    )
}

export default Payment