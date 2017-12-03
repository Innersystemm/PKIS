using SoapService.EntityClasses;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace SoapService.Contexts
{
    public class LogDbContext : DbContext
    {
        public LogDbContext(string connectionString) : base(connectionString)
        {
            Database.SetInitializer(new LogInitializer());
        }

        public DbSet<Log> Logs { get; set; }
    }

    public class LogInitializer: CreateDatabaseIfNotExists<LogDbContext>
    {
        protected override void Seed(LogDbContext context)
        {
            base.Seed(context);
        }
    }
}