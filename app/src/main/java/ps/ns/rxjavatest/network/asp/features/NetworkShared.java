package ps.ns.rxjavatest.network.asp.features;

public class NetworkShared {

    private static ASP asp;

    public static ASP getAsp() {
        if (asp == null)
            asp = new ASP();
        return asp;
    }

    public static class ASP {

        private General mGeneral;

        public ASP() {
            mGeneral = new General();
            mGeneral = new General();
            //    mUser = new User();

        }

        public General getRestaurant() {
            return mGeneral;
        }


    }

}
