class Branch {

    private int id;
    private String name;
    private Account []  accounts = new Account[20];
    private int accountCount = 0;
    private static Branch[] branches=new Branch[20];
    private static int branchcount = 0;
    // add your code here
    // there can be at most 20 branches  

     // you are not allowed to write any other constructor
    Branch(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[10];
        branches[branchcount++] = this;
        // add your code here
    }
    String getBankname()
    {
        return name;
    }
    int getBankId()
    {
        return id;
    }
    void addAccount(Account a) {
        accounts[accountCount++] = a;
    }
     double getBranchBalance(){
         double b=0;
            for(int i = 0; i<accountCount; i++)
            {
                b+=accounts[i].getBalance();
            }
         return b;
    }
    Account getMinBalanceAccount(){
        double min = accounts[0].getBalance();
        Account minacc = accounts[0];
        for(int i = 0; i<accountCount; i++)
        {
            if(accounts[i].getBalance()<min)
            {
                min = accounts[i].getBalance();
                minacc = accounts[i];
            }
        }
        return minacc;
    }
    static void transferBalance(Account from, Account to, double amount)
    {
        if(from.getBalance()>=amount)
        {
            from.setBalance(-1*amount);
            to.setBalance(amount);
        }else
        {
            System.out.println("Insufficient Balance\n");
        }
    }
    static void printAllBranchesInfo()
    {
        for(int i = 0; i<branchcount; i++)
        {
            Branch a = branches[i];
            System.out.println("Branch ID: "+a.id+" Branch Name: "+ a.name);
            System.out.println("_________________________________");
            for(int j = 0; j<a.accountCount; j++)
            {
                a.accounts[j].printAccountInfo();
            }
        }
    }
    // add your code here

}
